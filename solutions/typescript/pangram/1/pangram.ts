const alphabet = Array.from("abcdefghijklmnopqrstuvwxyz")

export function isPangram(text: string): boolean {
  const lowerText = text.toLowerCase()
  return alphabet.every(letter => lowerText.includes(letter))
}
