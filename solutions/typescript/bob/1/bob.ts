export function hey(message: string): string {
  const trimmed = message.trim()

  const isEmpty = trimmed === ""
  const isQuestion = trimmed.endsWith("?")
  const isYelled =
    /\p{L}/u.test(trimmed) && trimmed === trimmed.toLocaleUpperCase()

  if (isEmpty) return "Fine. Be that way!"
  if (isYelled && isQuestion) return "Calm down, I know what I'm doing!"
  if (isYelled) return "Whoa, chill out!"
  if (isQuestion) return "Sure."
  return "Whatever."
}
