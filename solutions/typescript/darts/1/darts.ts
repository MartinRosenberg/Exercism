const Circles = {
	inner: { radius: 1, value: 10 },
	middle: { radius: 5, value: 5 },
	outer: { radius: 10, value: 1 },
}

function score(x: number, y: number): number {
	const distanceFromOrigin = Math.sqrt(x ** 2 + y ** 2)
	if (distanceFromOrigin <= Circles.inner.radius) return Circles.inner.value
	if (distanceFromOrigin <= Circles.middle.radius) return Circles.middle.value
	if (distanceFromOrigin <= Circles.outer.radius) return Circles.outer.value
	return 0
}

export { score }
