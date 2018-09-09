package fr.cnes.sonar.tests;/*
 * This file is part of cnesreport.
 *
 * cnesreport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * cnesreport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with cnesreport.  If not, see <http://www.gnu.org/licenses/>.
 */

import fr.cnes.sonar.report.utils.Params;
import fr.cnes.sonar.report.model.*;
import org.junit.Before;

import java.util.*;

/**
 * Contains common code for tests
 * @author lequal
 */
public class CommonTest {

    /**
     * Severity for stubbed violations
     */
    private static final String MAJOR = "MAJOR";
    /**
     * Stubbed report for tests
     */
    protected Report report;
    /**
     * stubbed parameters for testing
     */
    protected Params params;

    /**
     * Setting of all stubbed resources before launching a test
     */
    @Before
    public void before() {
        report = new Report();
        params = new Params();

        report.setProjectName("GENIUS");
        report.setProjectDate(new Date().toString());
        report.setProjectAuthor("Lequal");

        final List<Issue> issues = new ArrayList<>();
        final Issue i1 = new Issue();
        final Issue i2 = new Issue();
        issues.add(i1);
        issues.add(i2);
        i1.setComponent("a");
        i1.setKey("z");
        i1.setLine("15");
        i1.setMessage("azerty");
        i1.setProject("genius");
        i1.setSeverity(MAJOR);
        i1.setStatus("OPEN");
        i1.setType("BUG");
        i2.setComponent("b");
        i2.setKey("x");
        i2.setLine("23");
        i2.setMessage("qwertz");
        i2.setProject("genius");
        i2.setSeverity(MAJOR);
        i2.setStatus("OPEN");
        i2.setType("SECURITY");
        report.setIssues(issues);

        final List<Facet> facets = new ArrayList<>();
        final Facet rules = new Facet();
        rules.setProperty("rules");
        final List<Value> values = new ArrayList<>();
        values.add(new Value("squid:S1258", 3));
        rules.setValues(values);
        facets.add(rules);
        report.setFacets(facets);

        final ProfileData profileData = new ProfileData();
        profileData.setConf("coucou");
        final List<Rule> rulesOfProfile = new ArrayList<>();
        final Rule rule1 = new Rule();
        rule1.setKey("squid:S1258");
        rule1.setName("Nom swag");
        rule1.setHtmlDesc("Cette description est pas trop longue donc ça va en fait, faut pas s'inquiéter.");
        rule1.setSeverity(MAJOR);
        rule1.setType("BUG");
        rulesOfProfile.add(rule1);
        profileData.setRules(rulesOfProfile);
        final ProfileMetaData profileMetaData = new ProfileMetaData();
        profileMetaData.setName("BG");
        profileMetaData.setKey("BG");
        final QualityProfile qualityProfile = new QualityProfile(profileData, profileMetaData);
        qualityProfile.setProjects((new Project[]{new Project("sonar-cnes-plugin", "sonar-cnes-plugin", "none","","")}));
        report.setQualityProfiles(Collections.singletonList(qualityProfile));
        final QualityGate qualityGate = new QualityGate();
        qualityGate.setName("CNES");
        report.setQualityGate(qualityGate);

        final Language language = new Language();
        language.setKey("java");
        language.setName("Java");

        final Map<String, Language> languages = new HashMap<>();
        languages.put(language.getKey(), language);

        final Project project = new Project("key", "Name", "none","Version", "Short description");
        project.setQualityProfiles(new ProfileMetaData[0]);
        project.setLanguages(languages);
        report.setProject(project);

        final List<Measure> measures = new ArrayList<>();
        measures.add(new Measure("reliability_rating", "1.0"));
        measures.add(new Measure("duplicated_lines_density", "1.0"));
        measures.add(new Measure("sqale_rating", "1.0"));
        measures.add(new Measure("coverage", "1.0"));
        measures.add(new Measure("ncloc", "1.0"));
        measures.add(new Measure("alert_status", "1.0"));
        measures.add(new Measure("security_rating", "1.0"));
        report.setMeasures(measures);

        params.put("sonar.url", "http://sonarqube:9000");
        params.put("sonar.project.id", "sonar-report-cnes");
        params.put("project.name", "Sonar Report CNES");
        params.put("report.author", "Lequal");
        params.put("report.date", new Date().toString());
        params.put("report.path", "./target");
        params.put("report.locale", "en_US");
        params.put("report.template", "src/main/resources/template/code-analysis-template.docx");
        params.put("issues.template", "src/main/resources/template/issues-template.xlsx");
    }
}
