const COLORS = {
  black: 0,
  brown: 1,
  red: 2,
  orange: 3,
  yellow: 4,
  green: 5,
  blue: 6,
  violet: 7,
  grey: 8,
  white: 9,
} as const;

type Colors = (keyof typeof COLORS)[];

const UNITS = {
  KILO: 1_000,
  MEGA: 1_000_000,
  GIGA: 1_000_000_000,
} as const;

function getUnit(n: number): string {
  if (n >= UNITS.GIGA) return "gigaohms";
  if (n >= UNITS.MEGA) return "megaohms";
  if (n >= UNITS.KILO) return "kiloohms";
  return "ohms";
}

function countZero(n: number): number {
  if (n >= UNITS.GIGA) return 9;
  if (n >= UNITS.MEGA) return 6;
  if (n >= UNITS.KILO) return 3;
  return 0;
}

export function decodedResistorValue([first, second, third]: Colors): string {
  const result = (COLORS[first] * 10 + COLORS[second]) * 10 ** COLORS[third];

  return `${result / (10 ** countZero(result))} ${getUnit(result)}`;
}
