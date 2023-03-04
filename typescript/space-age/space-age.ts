const PLANETS = {
  earth: 1,
  mercury: 0.2408467,
  venus: 0.61519726,
  mars: 1.8808158,
  jupiter: 11.862615,
  saturn: 29.447498,
  uranus: 84.016846,
  neptune: 164.79132,
};

type Planet = keyof typeof PLANETS;

export function age(planet: Planet, seconds: number): number {
  const earthYearInSeconds = 31557600;
  return Number((seconds / (earthYearInSeconds * PLANETS[planet])).toFixed(2));
}

// 1 : 31557600  = x : seconds
// 31557600x = seconds
// x = seconds / 31557600
