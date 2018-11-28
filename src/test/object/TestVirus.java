package test.object;

import object.*;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TestVirus {

    /* TEST: getName */
    @Test
    public void testGetName() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        String result = virus.getName();
        assertEquals("test", result);
    }

    /* TEST: setName */
    @Test
    public void testSetName() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        virus.setName("changedName");
        String result = virus.getName();
        assertEquals("changedName", result);
    }

    /* TEST: getTransmissionList */
    @Test
    public void testGetTransmissionList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
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
    public void testGetSymptomList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
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
    public void testGetAbilityList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
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

    /* TEST: getInfectPerDay */
    @Test
    public void testGetInfectPerDayC1() {

        class StubVirus extends Virus {
            private double virusSpeed = 0.01;

            public StubVirus(String name, ArrayList<VirusTransmission> transmissionList, ArrayList<VirusSymptom> symptomList, ArrayList<VirusAbility> abilityList) {
                super(name, transmissionList, symptomList, abilityList);
            }

            @Override
            public int getInfectPerDay(Country c, int day) {
                // assume no error in the method getInfectionPower()
                int resultOfGetInfectionPower = 0;
                if (resultOfGetInfectionPower == 0) {
                    return (int) (day * day * c.getMedicalSystem());
                } else {
                    return (int) (day * day * c.getMedicalSystem() + (c.getUninfectedPopulation() * (1 - c.getMedicalSystem()) * virusSpeed * (1 + resultOfGetInfectionPower)));
                }
            }
        }

        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        StubVirus stubVirus = new StubVirus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = stubVirus.getInfectPerDay(country, 10);
        assertEquals(1000, result);
    }

    @Test
    public void testGetInfectPerDayC2() {

        class StubVirus extends Virus {
            private double virusSpeed = 0.01;

            public StubVirus(String name, ArrayList<VirusTransmission> transmissionList, ArrayList<VirusSymptom> symptomList, ArrayList<VirusAbility> abilityList) {
                super(name, transmissionList, symptomList, abilityList);
            }

            @Override
            public int getInfectPerDay(Country c, int day) {
                // assume no error in the method getInfectionPower()
                int resultOfGetInfectionPower = 5;
                if (resultOfGetInfectionPower == 0) {
                    return (int) (day * day * c.getMedicalSystem());
                } else {
                    return (int) (day * day * c.getMedicalSystem() + (c.getUninfectedPopulation() * (1 - c.getMedicalSystem()) * virusSpeed * (1 + resultOfGetInfectionPower)));
                }
            }
        }

        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        StubVirus stubVirus = new StubVirus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = stubVirus.getInfectPerDay(country, 10);
        assertEquals(333, result);
    }


    /* getKillPerDay */

    @Test
    public void testGetKillPerDayC1() {
        class StubVirus extends Virus {
            private double virusPower = 0.01;

            public StubVirus(String name, ArrayList<VirusTransmission> transmissionList, ArrayList<VirusSymptom> symptomList, ArrayList<VirusAbility> abilityList) {
                super(name, transmissionList, symptomList, abilityList);
            }

            @Override
            public int getKillPerDay(Country c) {
                // assume no error in the method getSymptomKillPower()
                int resultOfGetSymptomKillPower = 0;
                if (resultOfGetSymptomKillPower == 0) {
                    return 0;
                } else {
                    return (int) (c.getInfectedPopulation() * (1 - c.getMedicalSystem()) * virusPower * (1 + resultOfGetSymptomKillPower));
                }
            }
        }

        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};
        StubVirus stubVirus = new StubVirus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = stubVirus.getKillPerDay(country);
        assertEquals(0, result);
    }

    @Test
    public void testGetKillPerDayC2() {

        class StubVirus extends Virus {
            private double virusPower = 0.01;

            public StubVirus(String name, ArrayList<VirusTransmission> transmissionList, ArrayList<VirusSymptom> symptomList, ArrayList<VirusAbility> abilityList) {
                super(name, transmissionList, symptomList, abilityList);
            }

            @Override
            public int getKillPerDay(Country c) {
                // assume no error in the method getSymptomKillPower()
                int resultOfGetSymptomKillPower = 10;
                if (resultOfGetSymptomKillPower == 0) {
                    return 0;
                } else {
                    // c.getInfectedPopulation() is 0
                    return (int) (c.getInfectedPopulation() * (1 - c.getMedicalSystem()) * virusPower * (1 + resultOfGetSymptomKillPower));
                }
            }
        }

        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        StubVirus stubVirus = new StubVirus("test", transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        int result = stubVirus.getKillPerDay(country);
        assertEquals(0, result);
    }


    /* TEST: getInfectionPower */

    @Test
    public void testGetInfectionPowerC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{}};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{}};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{}};

        Virus virus = new Virus("test",transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = virus.getInfectionPower(country);
        assertEquals(0.0, result);
    }

    @Test
    public void testGetInfectionPowerC2() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{}};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 0.1));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 0.2));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{}};

        symptomList.get(1).setResearched(true);
        symptomList.get(1).upLevel();

        Virus virus = new Virus("test",transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = virus.getInfectionPower(country);
        assertEquals(2.0, result);
    }

    @Test
    public void testGetInfectionPowerC3() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{}};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{}};

        transmissionList.get(1).setResearched(true);
        transmissionList.get(1).upLevel();

        Virus virus = new Virus("test",transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = virus.getInfectionPower(country);
        assertEquals(2.0, result);
    }

    @Test
    public void testGetInfectionPowerC4() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{}};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{}};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        abilityList.get(0).setResearched(true);
        abilityList.get(0).upLevel();

        Virus virus = new Virus("test",transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = virus.getInfectionPower(country);
        assertEquals(0.1, result);
    }

    @Test
    public void testGetInfectionPowerC5() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{}};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{}};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        abilityList.get(1).setResearched(true);
        abilityList.get(1).upLevel();

        Virus virus = new Virus("test",transmissionList, symptomList, abilityList);
        Country country = new Country("test", 1234, 0.5, CountryClimate.Hot);
        double result = virus.getInfectionPower(country);
        assertEquals(0.05, result);
    }

    /* TEST: getSymptomKillPower */

    @Test
    public void testGetSymptomKillPowerC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>() {{
            add(new VirusTransmission("tran1", "dTran1", 1.0));
            add(new VirusTransmission("tran2", "dTran2", 2.0));
        }};
        ArrayList<VirusSymptom> symptomList = new ArrayList<VirusSymptom>() {{
            add(new VirusSymptom("symp1", "dSymp1", 1.0, 1.0));
            add(new VirusSymptom("symp2", "dSymp2", 2.0, 2.0));
        }};
        ArrayList<VirusAbility> abilityList = new ArrayList<VirusAbility>() {{
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
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
            add(new VirusAbility("abi1", "dAbi1", CountryClimate.Hot));
            add(new VirusAbility("abi2", "dAbi2", CountryClimate.Cold));
        }};

        symptomList.get(1).setResearched(true);
        symptomList.get(1).upLevel();

        Virus virus = new Virus("test", transmissionList, symptomList, abilityList);
        double result = virus.getSymptomKillPower();
        assertEquals(3.0, result);
    }

}
