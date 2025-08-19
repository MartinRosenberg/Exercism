const secondsPerEarthYear = 31557600

const planetCoefficients = {
	mercury: 0.2408467,
	venus: 0.61519726,
	earth: 1.0,
	mars: 1.8808158,
	jupiter: 11.862615,
	saturn: 29.447498,
	uranus: 84.016846,
	neptune: 164.79132,
}

type Planet = keyof typeof planetCoefficients

function roundToHundredths(n: number): number {
	return Math.round((n + Number.EPSILON) * 100) / 100
}

export function age(planet: Planet, seconds: number): number {
	const years = seconds / (secondsPerEarthYear * planetCoefficients[planet])
	return roundToHundredths(years)
}
