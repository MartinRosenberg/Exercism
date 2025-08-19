const stop = 'STOP'
const methionine = 'Methionine'
const phenylalanine = 'Phenylalanine'
const leucine = 'Leucine'
const serine = 'Serine'
const tyrosine = 'Tyrosine'
const cysteine = 'Cysteine'
const tryptophan = 'Tryptophan'

const codonToProtein = {
  AUG: methionine,
  UUU: phenylalanine, UUC: phenylalanine,
  UUA: leucine, UUG: leucine,
  UCU: serine, UCC: serine, UCA: serine, UCG: serine,
  UAU: tyrosine, UAC: tyrosine,
  UGU: cysteine, UGC: cysteine,
  UGG: tryptophan,
  UAA: stop, UAG: stop, UGA: stop,
}

const codonWidth = 3

export const translate = (rna) => {
  if (!rna) return [] // Not sure why this is required
  if (rna.length % codonWidth !== 0 || !rna.match(/[GUAC]/g)) {
    throw new Error('Invalid codon')
  }
  let polypeptide = []
  for (let i = 0; i < rna.length; i += codonWidth) {
    const protein = codonToProtein[rna.substring(i, i + codonWidth)]
    if (protein === stop) break
    polypeptide.push(protein)
  }
  return polypeptide
}
