function decodedValue(colors: Array<(typeof COLORS)[number]>): number {
	const value = colors
		.slice(0, 2)
		.map((color) => COLORS.indexOf(color))
		.join("")
	return Number(value)
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

export { COLORS, decodedValue }
