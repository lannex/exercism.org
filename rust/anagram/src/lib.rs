use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let lowered_word = word.to_lowercase();
    let sorted_word = sort_word(&lowered_word);

    possible_anagrams
        .iter()
        .filter(|&&x| {
            let lowered_possible_anagram = x.to_lowercase();
            lowered_word != lowered_possible_anagram
                && sorted_word == sort_word(&lowered_possible_anagram)
        })
        .cloned()
        .collect()
}

fn sort_word(word: &str) -> String {
    let mut char_vec: Vec<char> = word.chars().collect();
    char_vec.sort();
    char_vec.into_iter().collect()
}
