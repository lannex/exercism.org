"""Functions used in preparing Guido's gorgeous lasagna.

Learn about Guido, the creator of the Python language:
https://en.wikipedia.org/wiki/Guido_van_Rossum

This is a module docstring, used to describe the functionality
of a module and its functions and/or classes.
"""

EXPECTED_BAKE_TIME = 40
TIME_PER_LAYER = 2


def bake_time_remaining(elapsed_bake_time: int) -> int:
    """Calculate remaining bake time in minutes.

    :param elapsed_bake_time: int
    :return: int
    """
    return EXPECTED_BAKE_TIME - elapsed_bake_time


def preparation_time_in_minutes(layer: int) -> int:
    """Calculate preparation time in minutes.

    :param layer: int
    :return: int
    """
    return layer * TIME_PER_LAYER


def elapsed_time_in_minutes(prep: int, elapsed: int) -> int:
    """Calculate total elapsed cooking time (prep + bake) in minutes.

    :param prep: int
    :param elapsed: int
    :return: int
    """
    return preparation_time_in_minutes(prep) + elapsed
