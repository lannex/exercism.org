#[derive(Debug)]
pub struct Duration(f64);

impl From<u64> for Duration {
    fn from(s: u64) -> Self {
        Duration(s as f64 / 60.0 / 60.0 / 24.0)
    }
}

pub trait Planet {
    const ORBITAL_PERIOD_RATIO: f64;

    fn years_during(d: &Duration) -> f64 {
        let earth_days_per_year = 365.25;
        d.0 / (Self::ORBITAL_PERIOD_RATIO * earth_days_per_year)
    }
}

pub struct Mercury;
pub struct Venus;
pub struct Earth;
pub struct Mars;
pub struct Jupiter;
pub struct Saturn;
pub struct Uranus;
pub struct Neptune;

impl Planet for Mercury {
    const ORBITAL_PERIOD_RATIO: f64 = 0.2408467;
}

impl Planet for Venus {
    const ORBITAL_PERIOD_RATIO: f64 = 0.61519726;
}

impl Planet for Earth {
    const ORBITAL_PERIOD_RATIO: f64 = 1.0;
}

impl Planet for Mars {
    const ORBITAL_PERIOD_RATIO: f64 = 1.8808158;
}

impl Planet for Jupiter {
    const ORBITAL_PERIOD_RATIO: f64 = 11.862615;
}

impl Planet for Saturn {
    const ORBITAL_PERIOD_RATIO: f64 = 29.447498;
}

impl Planet for Uranus {
    const ORBITAL_PERIOD_RATIO: f64 = 84.016846;
}

impl Planet for Neptune {
    const ORBITAL_PERIOD_RATIO: f64 = 164.79132;
}