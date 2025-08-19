function isLeap(year: number): boolean {
	const divisibleBy = (n: number): boolean => year % n === 0
	return divisibleBy(4) && (!divisibleBy(100) || divisibleBy(400))
}

export { isLeap }
