export const validate = (number) => {
  const digits = `${number}`.split('')
  const { length } = digits
  const sum = digits.reduce((a, c) => a + c ** length, 0)
  return number === sum
}
