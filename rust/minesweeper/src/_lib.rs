use std::char::from_digit;

#[rustfmt::skip]
const DIRECTIONS: [(i32, i32); 8] = [
    (-1, -1), (0, -1), (1, -1),
    (-1,  0),          (1,  0),
    (-1,  1), (0,  1), (1,  1),
];

pub fn annotate(minefield: &[&str]) -> Vec<String> {
    let mut result = Vec::new();

    for (y, &row) in minefield.iter().enumerate() {
        let y_ = y as i32;
        let mut row_ = String::new();

        for (x, cell) in row.chars().enumerate() {
            let x_ = x as i32;

            row_.push(match cell {
                '*' => '*',
                _ => {
                    let count = count_adjacent_mines(x_, y_, row, minefield);
                    get_count_char(count)
                }
            });
        }
        result.push(row_);
    }

    result
}

fn get_count_char(count: usize) -> char {
    match count {
        0 => ' ',
        _ => from_digit(count as u32, 10).unwrap_or(' '),
    }
}

fn count_adjacent_mines(x_: i32, y_: i32, row: &str, minefield: &[&str]) -> usize {
    DIRECTIONS
        .iter()
        .filter(|&&(dx, dy)| {
            let nx = x_ + dx;
            let ny = y_ + dy;
            let row_len = row.len() as i32;
            let minefield_len = minefield.len() as i32;

            if nx >= 0 && nx < row_len && ny >= 0 && ny < minefield_len {
                minefield[ny as usize].chars().nth(nx as usize).unwrap() == '*'
            } else {
                false
            }
        })
        .count()
}
