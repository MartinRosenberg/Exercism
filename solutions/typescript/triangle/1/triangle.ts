export class Triangle {
  readonly isEquilateral: boolean
  readonly isIsosceles: boolean
  readonly isScalene: boolean

  constructor(a: number, b: number, c: number) {
    const isValidTriangle =
      a > 0 && b > 0 && c > 0 && a + b > c && b + c > a && c + a > b

    if (isValidTriangle) {
      this.isEquilateral = a === b && b === c
      this.isIsosceles = a === b || b === c || c === a
      this.isScalene = a !== b && b !== c
    } else {
      this.isEquilateral = this.isIsosceles = this.isScalene = false
    }
  }
}
