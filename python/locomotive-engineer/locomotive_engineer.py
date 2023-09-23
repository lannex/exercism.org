def get_list_of_wagons(*items: int) -> list[int]:
    return [*items]


def fix_list_of_wagons(
    each_wagons_id: list[int], missing_wagons: list[int]
) -> list[int]:
    x, y, z, *rest = each_wagons_id
    return [z, *missing_wagons, *rest, x, y]


def add_missing_stops(
    route: dict[str, str], **stops: dict[str, str]
) -> dict[str, str | list[dict[str, str]]]:
    return {**route, "stops": list(stops.values())}


def extend_route_information(
    route: dict[str, str], more_route_information: dict[str, str]
) -> dict[str, str]:
    return {**route, **more_route_information}


def fix_wagon_depot(
    wagons_rows: list[list[tuple[int, str]]]
) -> list[list[tuple[int, str]]]:
    zipped = zip(*wagons_rows)
    return list(map(list, zipped))
