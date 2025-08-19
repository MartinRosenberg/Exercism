export default class Squares {
    private _squareOfSum: number
    private _sumOfSquares: number
    private _difference: number

    constructor (private readonly n: number) {
        this._squareOfSum = (this.n * (this.n + 1) / 2) ** 2
        this._sumOfSquares = this.n * (this.n + 1) * (2 * this.n + 1) / 6
        this._difference = this._squareOfSum - this._sumOfSquares
    }

    get squareOfSum (): number {
        return this._squareOfSum
    }

    get sumOfSquares (): number {
        return this._sumOfSquares
    }

    get difference (): number {
        return this._difference
    }
}
