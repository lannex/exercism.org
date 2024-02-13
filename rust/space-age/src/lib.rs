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

macro_rules! planet {
    ( $id: ident, $value: expr ) => {
        pub struct $id;

        impl Planet for $id {
            const ORBITAL_PERIOD_RATIO: f64 = $value;
        }
    };
}

planet!(Mercury, 0.2408467);
planet!(Venus, 0.61519726);
planet!(Earth, 1.0);
planet!(Mars, 1.8808158);
planet!(Jupiter, 11.862615);
planet!(Saturn, 29.447498);
planet!(Uranus, 84.016846);
planet!(Neptune, 164.79132);
