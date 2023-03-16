export class Matrix {
  constructor(private input: string) {}

  get rows() {
    return this.input.split("\n").map((row) => row.split(" ").map(Number));
  }

  get columns() {
    const columLength = this.rows[0];
    return columLength.map((_, colIndex) =>
      this.rows.map((row) => row[colIndex])
    );
  }
}
