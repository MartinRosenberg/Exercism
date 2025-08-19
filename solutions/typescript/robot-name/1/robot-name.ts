export class Robot {
	private _name: string

	constructor() {
		this._name = Robot.#generateUniqueName()
	}

	get name(): string {
		return this._name
	}

	resetName(): void {
		this._name = Robot.#generateUniqueName()
	}

	static releaseNames(): void {
		Robot.#usedNames.clear()
	}

	static #usedNames: Set<string> = new Set()

	static #generateUniqueName(): string {
		if (Robot.#usedNames.size >= 676000) {
			throw Error("All possible robot names have been used.")
		}
		while (true) {
			const name = Robot.#randomName()
			if (!Robot.#usedNames.has(name)) {
				Robot.#usedNames.add(name)
				return name
			}
		}
	}

	static #randomName(): string {
		return `${Robot.#randomLetter()}${Robot.#randomLetter()}${Robot.#randomNumber()}`
	}

	static #randomLetter(): string {
		return String.fromCharCode(65 + Math.floor(Math.random() * 26))
	}

	static #randomNumber(): string {
		return Math.floor(Math.random() * 1000)
			.toString()
			.padStart(3, "0")
	}
}
