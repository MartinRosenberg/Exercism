const DnaBaseToRnaBase = { A: "U", C: "G", G: "C", T: "A" } as const

type Strand<BaseType extends string = string> = Array<BaseType>
type DnaBase = keyof typeof DnaBaseToRnaBase

const DnaBases = Object.keys(DnaBaseToRnaBase)
function isDnaStrand (strand: Strand): strand is Strand<DnaBase> {
  return strand.every((base): base is DnaBase => DnaBases.includes(base))
}

export function toRna (dna: string): string | never {
  const strand = Array.from(dna)
  if (!isDnaStrand(strand)) {
    throw Error("Invalid input DNA.")
  }
  return strand.map(base => DnaBaseToRnaBase[base]).join("")
}
