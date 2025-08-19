export const COLORS = [
  'black',
  'brown',
  'red',
  'orange',
  'yellow',
  'green',
  'blue',
  'violet',
  'grey',
  'white',
] as const

export const colorCode = (color: typeof COLORS[number]): keyof typeof COLORS =>
  COLORS.indexOf(color)
