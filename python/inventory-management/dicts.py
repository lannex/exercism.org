"""Functions to keep track and alter inventory."""


def create_inventory(items: list[str]) -> dict[str, int]:
    """Create a dict that tracks the amount (count) of each element on the `items` list.

    :param items: list - list of items to create an inventory from.
    :return: dict - the inventory dictionary.
    """

    return dict((item, items.count(item)) for item in items)


def add_items(inventory: dict[str, int], items: list[str]) -> dict[str, int]:
    """Add or increment items in inventory using elements from the items `list`.

    :param inventory: dict - dictionary of existing inventory.
    :param items: list - list of items to update the inventory with.
    :return: dict - the inventory updated with the new items.
    """

    cloned_inventory = inventory.copy()
    for item in items:
        if item in cloned_inventory:
            cloned_inventory[item] += 1
        else:
            cloned_inventory[item] = 1

    return cloned_inventory


def decrement_items(inventory: dict[str, int], items: list[str]) -> dict[str, int]:
    """Decrement items in inventory using elements from the `items` list.

    :param inventory: dict - inventory dictionary.
    :param items: list - list of items to decrement from the inventory.
    :return: dict - updated inventory with items decremented.
    """

    cloned_inventory = inventory.copy()
    for item in items:
        if cloned_inventory[item] > 0:
            cloned_inventory[item] -= 1

    return cloned_inventory


def remove_item(inventory: dict[str, int], item: str) -> dict[str, int]:
    """Remove item from inventory if it matches `item` string.

    :param inventory: dict - inventory dictionary.
    :param item: str - item to remove from the inventory.
    :return: dict - updated inventory with item removed. Current inventory if item does not match.
    """

    cloned_inventory = inventory.copy()
    cloned_inventory.pop(item, None)

    return cloned_inventory


def list_inventory(inventory: dict[str, int]) -> list[tuple[str, int]]:
    """Create a list containing all (item_name, item_count) pairs in inventory.

    :param inventory: dict - an inventory dictionary.
    :return: list of tuples - list of key, value pairs from the inventory dictionary.
    """

    return [(key, val) for key, val in inventory.items() if val > 0]
