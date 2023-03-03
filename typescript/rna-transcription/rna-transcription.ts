type DNA = "G" | "C" | "T" | "A";
type RNA = "C" | "G" | "A" | "U";

const dnaToRna = new Map<DNA, RNA>([
  ["G", "C"],
  ["C", "G"],
  ["T", "A"],
  ["A", "U"],
]);

const isDna = (nucleotide: string): nucleotide is DNA =>
  dnaToRna.has(nucleotide as DNA);

export function toRna(dna: string): string {
  return dna
    .split("")
    .map((nucleotide: DNA | string) => {
      if (!isDna(nucleotide)) {
        throw new Error("Invalid input DNA.");
      }
      return dnaToRna.get(nucleotide);
    })
    .join("");
}
