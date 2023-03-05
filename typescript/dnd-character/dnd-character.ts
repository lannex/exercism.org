export class DnDCharacter {
  public readonly strength: number = DnDCharacter.generateAbilityScore();

  public readonly dexterity: number = DnDCharacter.generateAbilityScore();

  public readonly constitution: number = DnDCharacter.generateAbilityScore();

  public readonly intelligence: number = DnDCharacter.generateAbilityScore();

  public readonly wisdom: number = DnDCharacter.generateAbilityScore();

  public readonly charisma: number = DnDCharacter.generateAbilityScore();

  public readonly hitpoints: number =
    10 + DnDCharacter.getModifierFor(this.constitution);

  public static generateAbilityScore(): number {
    const rolls = Array.from(
      { length: 4 },
      () => Math.floor(Math.random() * 6) + 1
    );
    return rolls
      .sort((a, b) => a - b)
      .slice(0, 3)
      .reduce((a, b) => a + b, 0);
  }

  public static getModifierFor(abilityValue: number): number {
    return Math.floor((abilityValue - 10) / 2);
  }
}
