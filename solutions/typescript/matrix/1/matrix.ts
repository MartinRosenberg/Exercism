class Matrix {
	readonly rows: Array<Array<number>>
	readonly columns: Array<Array<number>>

	constructor(matrix: string) {
		this.rows = matrix.split("\n").map((row) => row.split(" ").map(Number))
		this.columns = Array.from({ length: this.rows[0].length }, () => [])
		for (const [index, column] of this.columns.entries()) {
			for (const row of this.rows) {
				column.push(row[index])
			}
		}
	}
}

export { Matrix }
