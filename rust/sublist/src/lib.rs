#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

pub fn sublist<T: PartialEq>(first_list: &[T], second_list: &[T]) -> Comparison {
    if first_list == second_list {
        return Comparison::Equal;
    }

    let is_sub = is_sublist(first_list, second_list);
    let is_sup = is_sublist(second_list, first_list);

    match (is_sub, is_sup) {
        (true, false) => Comparison::Sublist,
        (false, true) => Comparison::Superlist,
        (false, false) => Comparison::Unequal,
        _ => panic!("Can't compare lists"),
    }
}

fn is_sublist<T: PartialEq>(a: &[T], b: &[T]) -> bool {
    a.is_empty() || b.windows(a.len()).any(|xs| xs == a)
}
