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

const SI_PREFIXES = [
	[1_000_000_000, "giga"],
	[1_000_000, "mega"],
	[1_000, "kilo"],
] as const

function decodedResistorValue(bands: Array<Color>): string {
	const [tens, ones, exponent] = bands.map((band) => COLORS.indexOf(band))
	const number = ((tens * 10) + ones) * (10 ** exponent)
	const [divisor, prefix] = SI_PREFIXES.find(([d]) => number >= d) ?? [1, ""]

	return `${number / divisor} ${prefix}ohms`
}

export { decodedResistorValue }
