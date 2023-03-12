const isSilence = (trimmedMessage: string): boolean => trimmedMessage === "";

const isQuestion = (trimmedMessage: string): boolean =>
  trimmedMessage.endsWith("?");

const isYelling = (trimmedMessage: string): boolean =>
  trimmedMessage.toUpperCase() === trimmedMessage &&
  /[A-Z]/.test(trimmedMessage);

export function hey(message: string): string {
  const trimmedMessage = message.trim();

  const isQuestion_ = isQuestion(trimmedMessage);
  const isYelling_ = isYelling(trimmedMessage);

  if (isYelling_ && isQuestion_) {
    return "Calm down, I know what I'm doing!";
  }

  if (isSilence(trimmedMessage)) {
    return "Fine. Be that way!";
  }

  if (isYelling_) {
    return "Whoa, chill out!";
  }

  if (isQuestion_) {
    return "Sure.";
  }

  return "Whatever.";
}
