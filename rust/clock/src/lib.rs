use std::fmt;

const MINUTES_PER_DAY: i32 = 24 * 60;
const MINUTES_PER_HOUR: i32 = 60;

#[derive(Debug, PartialEq)]
pub struct Clock {
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        Self {
            minutes: (hours * MINUTES_PER_HOUR + minutes).rem_euclid(MINUTES_PER_DAY),
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self {
            minutes: (self.minutes + minutes).rem_euclid(MINUTES_PER_DAY),
        }
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, formatter: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(
            formatter,
            "{:02}:{:02}",
            self.minutes / MINUTES_PER_HOUR,
            self.minutes % MINUTES_PER_HOUR
        )
    }
}
