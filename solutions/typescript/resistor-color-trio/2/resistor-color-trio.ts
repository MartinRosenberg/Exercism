const COLORS = [
	"black",
	"brown",
	"red",
	"orange",
	"yellow",
	"green",
	"blue",
	"violet",
	"grey",
	"white",
] as const
type Color = (typeof COLORS)[number]

const SI_PREFIXES = ["", "kilo", "mega", "giga"]

function decodedResistorValue(colors: Array<Color>): string {
	const decodedColors = colors.map((color) => COLORS.indexOf(color as Color))
	let number =
		(decodedColors[0] * 10 + decodedColors[1]) * 10 ** decodedColors[2]
	let prefixIndex = 0
	while (true) {
		if (number % 1000 !== number) {
			number /= 1000
			prefixIndex++
		} else {
			return `${number} ${SI_PREFIXES[prefixIndex]}ohms`
		}
	}
}

export { decodedResistorValue }
