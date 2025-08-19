const Circles = {
	inner: { radius: 1, value: 10 },
	middle: { radius: 5, value: 5 },
	outer: { radius: 10, value: 1 },
}

function score(x: number, y: number): number {
	const distanceFromOrigin = Math.hypot(x, y)
	switch (true) {
		case distanceFromOrigin <= Circles.inner.radius:
			return Circles.inner.value
		case distanceFromOrigin <= Circles.middle.radius:
			return Circles.middle.value
		case distanceFromOrigin <= Circles.outer.radius:
			return Circles.outer.value
		default:
			return 0
	}
}

export { score }
