type GradeNumber = number
type StudentName = string
type GradeRoster = Array<StudentName>
type SchoolRoster = Record<GradeNumber, GradeRoster>

export class GradeSchool {
	private students: Map<StudentName, GradeNumber> = new Map()

  roster(): SchoolRoster {
		const unsortedRoster: SchoolRoster = {}

		for (const [name, grade] of this.students) {
			if (!(grade in unsortedRoster)) {
				unsortedRoster[grade] = []
			}
			unsortedRoster[grade].push(name)
		}
		
    return Object.fromEntries(
			Object.entries(unsortedRoster).map(
				([grade, roster]) => ([grade, roster.toSorted()])
			)
		)
  }

  add(studentName: StudentName, gradeNumber: GradeNumber): void {
		this.students.set(studentName, gradeNumber)
  }

  grade(gradeNumber: GradeNumber): GradeRoster {
    return Array.from(this.students).reduce<Array<string>>(
			(gradeRoster, [name, grade]) => {
				return grade === gradeNumber ? [...gradeRoster, name] : gradeRoster
			},
			[]
		).toSorted()
  }
}
