const factors = [[3, "Pling"], [5, "Plang"], [7,  "Plong"]] as const

export function convert(n: number): string {
  const words = factors.reduce(
    (acc, [factor, word]) => n % factor === 0 ? acc + word : acc,
    ""
  )
  return words || n.toString()
}

