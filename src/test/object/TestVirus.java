package test.object;

import object.*;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TestVirus {

    /* TEST: getName */

    @Test
    public void TestGetName() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        for (int i = 0; i < result.size() ; i++){
            assertEquals(transmissionList.get(i).getAtt_name(), result.get(i).getAtt_name());
            assertEquals(transmissionList.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(transmissionList.get(i).getInfectionRate(), result.get(i).getInfectionRate());
        }
    }

    /* TEST: addTransmissionList */

    @Test
    public void TestAddTransmissionList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        virus.addTransmissionList(new VirusTransmission("tran3", "dTran3", 3.0));
        ArrayList<VirusTransmission> result = virus.getTransmissionList();
        assertEquals(3, result.size());
        assertEquals("tran3", result.get(2).getAtt_name());
        assertEquals("dTran3", result.get(2).getDescription());
        assertEquals(3.0, result.get(2).getInfectionRate());
    }

    /* TEST: removeTransmissionList */

    @Test
    public void TestRemoveTransmissionList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        virus.removeTransmissionList(transmissionList.get(1));
        ArrayList<VirusTransmission> result = virus.getTransmissionList();
        assertEquals(1, result.size());
    }

    /* TEST: getSymptomList */

    @Test
    public void TestGetSymptomList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        for (int i = 0; i < result.size() ; i++){
            assertEquals(symptomList.get(i).getAtt_name(), result.get(i).getAtt_name());
            assertEquals(symptomList.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(symptomList.get(i).getInfectionRate(), result.get(i).getInfectionRate());
        }
    }

    /* TEST: addSymptomList */

    @Test
    public void TestAddSymptomList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        virus.addSymptomList(new VirusSymptom("symp3", "dSymp3", 3.0, 0.3));
        ArrayList<VirusSymptom> result = virus.getSymptomList();
        assertEquals(3, result.size());
        assertEquals("symp2", result.get(2).getAtt_name());
        assertEquals("dSymp3", result.get(2).getDescription());
        assertEquals(3.0, result.get(2).getInfectionRate());
    }

    /* TEST: removeSymptomList */

    @Test
    public void TestRemoveSymptomList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        virus.removeSymptomList(symptomList.get(1));
        ArrayList<VirusSymptom> result = virus.getSymptomList();
        assertEquals(1, result.size());
    }

    /* TEST: getAbilityList */

    @Test
    public void TestGetAbilityList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        for (int i = 0; i < result.size() ; i++){
            assertEquals(abilityList.get(i).getAtt_name(), result.get(i).getAtt_name());
            assertEquals(abilityList.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(abilityList.get(i).getInfectionRate(), result.get(i).getInfectionRate());
        }
    }

    /* TEST: addSymptomList */

    @Test
    public void TestAddAbilityList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        virus.addAbilityList(new VirusAbility("abi3", "dAbi3", 3.0, CountryClimate.Wet));
        ArrayList<VirusAbility> result = virus.getAbilityList();
        assertEquals(3, result.size());
        assertEquals("abi3", result.get(2).getAtt_name());
        assertEquals("dAbi3", result.get(2).getDescription());
        assertEquals(3.0, result.get(2).getInfectionRate());
        assertEquals(CountryClimate.Wet, result.get(2).getClimateBoost());
    }

    /* TEST: removeSymptomList */

    @Test
    public void TestRemoveAbilityList() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        virus.removeAbilityList(abilityList.get(1));
        ArrayList<VirusAbility> result = virus.getAbilityList();
        assertEquals(1, result.size());
    }

    /* getInfectPerDay */

    @Test
    public void TestGetInfectPerDayC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        assertEquals(-999.54, country.getUninfectedPopulation() * (1 - country.getMedicalSystem()) * 0.01 * (1 + virus.getInfectionPower(country)) );
        assertEquals(0, result);
    }

    /* getKillPerDay */

    @Test
    public void TestGetKillPerDayC1() {
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        ArrayList<VirusTransmission> transmissionList = new ArrayList<VirusTransmission>(){{
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
        Country country = new Country("test", 1234, 10.0, CountryClimate.Hot);
        country.setInfectedPopulation(100);
        int result = virus.getKillPerDay(country, 10);
        assertEquals(97.5,virus.getSymptomKillPower());
        assertEquals(1000, result);
    }
}
