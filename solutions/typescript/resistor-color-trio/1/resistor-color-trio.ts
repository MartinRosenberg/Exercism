function decodedResistorValue(colors: Array<(typeof COLORS)[number]>): string {
	const value = colors
		.slice(0, 2)
		.map((color) => COLORS.indexOf(color))
		.join("")
	const exponent = COLORS.indexOf(colors[2])
	const number = `${value}${"0".repeat(exponent)}`
	return number.endsWith("000")
		? `${number.slice(0, number.length - 3)} kiloohms`
		: `${number} ohms`
}

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

export { decodedResistorValue }
