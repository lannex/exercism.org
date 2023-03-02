const isDivisibleBy = (year: number, divisor: number): boolean =>
  year % divisor === 0;

export function isLeap(year: number): boolean {
  return (
    isDivisibleBy(year, 4) &&
    (!isDivisibleBy(year, 100) || isDivisibleBy(year, 400))
  );
}
