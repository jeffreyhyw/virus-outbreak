package test.object;

import object.*;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TestVirus {

    /* TEST: getName */

    @Test
    public void TestGetName() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        String result = virus.getName();
        assertEquals("test", result);
    }

    /* TEST: setName */

    @Test
    public void TestSetName() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        virus.setName("changedName");
        String result = virus.getName();
        assertEquals("changedName", result);
    }

    /* TEST: getTransmissionList */

    @Test
    public void TestGetTransmissionList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        ArrayList<VirusTransmission> result = virus.getTransmissionList();
        assertEquals(transmissionList.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(transmissionList.get(i).getAtt_name(), result.get(i).getAtt_name());
            assertEquals(transmissionList.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(transmissionList.get(i).getInfectionRate(), result.get(i).getInfectionRate());
        }
    }

    /* TEST: getSymptomList */

    @Test
    public void TestGetSymptomList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        ArrayList<VirusSymptom> result = virus.getSymptomList();
        assertEquals(symptomList.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(symptomList.get(i).getAtt_name(), result.get(i).getAtt_name());
            assertEquals(symptomList.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(symptomList.get(i).getInfectionRate(), result.get(i).getInfectionRate());
        }
    }

    /* TEST: getAbilityList */

    @Test
    public void TestGetAbilityList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        ArrayList<VirusAbility> result = virus.getAbilityList();
        assertEquals(abilityList.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(abilityList.get(i).getAtt_name(), result.get(i).getAtt_name());
            assertEquals(abilityList.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(abilityList.get(i).getInfectionRate(), result.get(i).getInfectionRate());
        }
    }

    /* getInfectPerDay */

    @Test
    public void TestGetInfectPerDayC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = virus.getInfectPerDay(country, 10);
        assertEquals(1000, result);
    }

    @Test
    public void TestGetInfectPerDayC2() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = virus.getInfectPerDay(country, 10);
        assertEquals(1000, result);
    }

    @Test
    public void TestGetInfectPerDayC3() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        transmissionList.get(0).setResearched(true);
        transmissionList.get(0).setLevel(2);
        transmissionList.get(1).setResearched(true);
        transmissionList.get(1).setLevel(3);

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = virus.getInfectPerDay(country, 10);
        assertEquals(8.0, virus.getInfectionPower(country));
        assertEquals(-999.54, country.getUninfectedPopulation() * (1 - country.getMedicalSystem()) * 0.01 * (1 + virus.getInfectionPower(country)));
        assertEquals(0, result);
    }

    /* getKillPerDay */

    @Test
    public void TestGetKillPerDayC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = virus.getKillPerDay(country, 10);
        assertEquals(0, result);
    }

    @Test
    public void TestGetKillPerDayC2() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = virus.getKillPerDay(country, 10);
        assertEquals(0, result);
    }

    @Test
    public void TestGetKillPerDayC3() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        symptomList.get(0).setResearched(true);
        symptomList.get(0).setKillPeopleRate(10.0);
        symptomList.get(0).setLevel(2);
        symptomList.get(1).setResearched(true);
        symptomList.get(1).setKillPeopleRate(15.0);
        symptomList.get(1).setLevel(3);

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        country.setInfectedPopulation(1080);
        int result = virus.getKillPerDay(country, 10);
        assertEquals(97.5, virus.getSymptomKillPower());
        assertEquals(531, result);
    }

    /* TEST: getInfectionPower */

    @Test
    public void testGetInfectionPowerC1() {
        class StubVirus {
            private ArrayList<VirusSymptom> symptomList;
            public double getInfectionPower(Country c) {
                double infectPower = 0;
                for (VirusSymptom vs : symptomList) {
                    if (vs.isResearched())
                        infectPower += vs.getInfectionRate() * vs.getLevel();
                }
                return infectPower;
            }
        }
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        StubVirus stubVirus = new StubVirus();
        stubVirus.symptomList = symptomList;
        stubVirus.symptomList.get(1).setResearched(true);
        stubVirus.symptomList.get(1).setLevel(2);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = stubVirus.getInfectionPower(country);
        assertEquals(4.0,result);
    }

    @Test
    public void testGetInfectionPowerC2() {
        class StubVirus {
            private ArrayList<VirusTransmission> transmissionList;
            public double getInfectionPower(Country c) {
                double infectPower = 0;
                for (VirusTransmission vt : transmissionList) {
                    if (vt.isResearched())
                        infectPower += vt.getInfectionRate() * vt.getLevel();
                }
                return infectPower;
            }
        }
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        StubVirus stubVirus = new StubVirus();
        stubVirus.transmissionList = transmissionList;
        stubVirus.transmissionList.get(1).setResearched(true);
        stubVirus.transmissionList.get(1).setLevel(2);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = stubVirus.getInfectionPower(country);
        assertEquals(4.0,result);
    }

    @Test
    public void testGetInfectionPowerC3() {
        class StubVirus {
            private ArrayList<VirusAbility> abilityList;
            public double getInfectionPower(Country c) {
                double infectPower = 0;
                for (VirusAbility va : abilityList) {
                    if (va.isResearched()) {
                        //Bost virus power if the climate of the place suitable for virus
                        if (va.getClimateBoost() == c.getClimate()) {
                            infectPower += va.getInfectionRate() * va.getLevel() * 2;
                        } else {
                            infectPower += va.getInfectionRate() * va.getLevel();
                        }
                    }
                }
                return infectPower;
            }
        }
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};
        StubVirus stubVirus = new StubVirus();
        stubVirus.abilityList = abilityList;
        stubVirus.abilityList.get(0).setResearched(true);
        stubVirus.abilityList.get(0).upLevel();
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = stubVirus.getInfectionPower(country);
        assertEquals(0.1,result);
    }

    @Test
    public void testGetInfectionPowerC4() {
        class StubVirus {
            private ArrayList<VirusAbility> abilityList;
            public double getInfectionPower(Country c) {
                double infectPower = 0;
                for (VirusAbility va : abilityList) {
                    if (va.isResearched()) {
                        //Bost virus power if the climate of the place suitable for virus
                        if (va.getClimateBoost() == c.getClimate()) {
                            infectPower += va.getInfectionRate() * va.getLevel() * 2;
                        } else {
                            infectPower += va.getInfectionRate() * va.getLevel();
                        }
                    }
                }
                return infectPower;
            }
        }
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};
        StubVirus stubVirus = new StubVirus();
        stubVirus.abilityList = abilityList;
        stubVirus.abilityList.get(1).setResearched(true);
        stubVirus.abilityList.get(1).upLevel();
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = stubVirus.getInfectionPower(country);
        assertEquals(0.05,result);
    }

    /* TEST: getSymptomKillPower */

    @Test
    public void testGetSymptomKillPowerC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        double result = virus.getSymptomKillPower();
        assertEquals(0.0, result);
    }

    @Test
    public void testGetSymptomKillPowerC2() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 1.0));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 2.0));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        double result = virus.getSymptomKillPower();
        assertEquals(0.0, result);
    }

    @Test
    public void testGetSymptomKillPowerC3() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 1.0));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 2.0));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        symptomList.get(0).setResearched(true);
        symptomList.get(0).setLevel(4);

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        double result = virus.getSymptomKillPower();
        assertEquals(6.0, result);
    }

    @Test
    public void testGetSymptomKillPowerC4() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 1.0));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 2.0));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", 1.0, CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", 2.0, CountryClimate.Cold));
        }};

        symptomList.get(0).setResearched(true);
        symptomList.get(0).setLevel(4);
        symptomList.get(1).setResearched(true);
        symptomList.get(1).setLevel(3);

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        double result = virus.getSymptomKillPower();
        assertEquals(15.0, result);
    }
}
