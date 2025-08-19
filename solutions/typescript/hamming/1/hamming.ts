export function compute(left: string, right: string): number | never {
	if (left.length !== right.length) {
		throw new Error("DNA strands must be of equal length.")
	}

	return Array.from(left)
		.reduce((sum, _, i) => left[i] === right[i] ? sum : sum + 1, 0)
}
