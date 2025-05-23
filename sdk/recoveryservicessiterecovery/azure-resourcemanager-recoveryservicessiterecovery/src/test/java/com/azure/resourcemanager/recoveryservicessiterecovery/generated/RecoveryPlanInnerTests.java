// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.fluent.models.RecoveryPlanInner;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.CurrentScenarioDetails;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.PossibleOperationsDirections;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanAction;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanActionDetails;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanGroup;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanGroupType;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanProperties;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanProtectedItem;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanProviderSpecificDetails;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.ReplicationProtectedItemOperation;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RecoveryPlanInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RecoveryPlanInner model = BinaryData.fromString(
            "{\"properties\":{\"friendlyName\":\"lpaugmrm\",\"primaryFabricId\":\"lrxw\",\"primaryFabricFriendlyName\":\"aukhfkvcisiz\",\"recoveryFabricId\":\"a\",\"recoveryFabricFriendlyName\":\"sx\",\"failoverDeploymentModel\":\"uivedwcgyeewxeiq\",\"replicationProviders\":[\"mgomg\",\"amljdlrgmsplzgau\",\"cshhv\"],\"allowedOperations\":[\"gnxkympqan\",\"rjkixtw\",\"taoypnyghshxc\",\"lhkgmnsghp\"],\"lastPlannedFailoverTime\":\"2021-02-16T02:21:14Z\",\"lastUnplannedFailoverTime\":\"2021-10-26T23:15:05Z\",\"lastTestFailoverTime\":\"2021-06-29T00:22:13Z\",\"currentScenario\":{\"scenarioName\":\"jkhvyomacluzvxnq\",\"jobId\":\"rpqpd\",\"startTime\":\"2021-08-05T21:29:24Z\"},\"currentScenarioStatus\":\"oi\",\"currentScenarioStatusDescription\":\"css\",\"groups\":[{\"groupType\":\"Boot\",\"replicationProtectedItems\":[{\"id\":\"csypobkdqzrdzsyl\",\"virtualMachineId\":\"lgtrczzy\"},{\"id\":\"xzji\",\"virtualMachineId\":\"vuaurk\"},{\"id\":\"ci\",\"virtualMachineId\":\"defxrdc\"}],\"startGroupActions\":[{\"actionName\":\"b\",\"failoverTypes\":[\"FinalizeFailback\",\"Failback\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"nnqbnqbp\",\"failoverTypes\":[\"Failback\",\"Commit\",\"PlannedFailover\",\"UnplannedFailover\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"ypxrx\",\"failoverTypes\":[\"Failback\",\"Failback\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"PrimaryToRecovery\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"tafsrbxrblmliowx\",\"failoverTypes\":[\"CompleteMigration\",\"FinalizeFailback\",\"Commit\",\"RepairReplication\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"nepzwakls\",\"failoverTypes\":[\"DisableProtection\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"wwrxaomzisgl\",\"failoverTypes\":[\"Failback\",\"ReverseReplicate\",\"RepairReplication\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]},{\"groupType\":\"Boot\",\"replicationProtectedItems\":[{\"id\":\"dhqoawj\",\"virtualMachineId\":\"yueayfbpcmsp\"},{\"id\":\"yrrueqth\",\"virtualMachineId\":\"gnmbscbbxigdhx\"},{\"id\":\"d\",\"virtualMachineId\":\"pedbwdpyqy\"}],\"startGroupActions\":[{\"actionName\":\"ubmdnafcbqwre\",\"failoverTypes\":[\"Failback\",\"FinalizeFailback\",\"CancelFailover\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"geleohdbvq\",\"failoverTypes\":[\"FinalizeFailback\",\"CompleteMigration\",\"TestFailoverCleanup\",\"UnplannedFailover\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"eonrlkwzdqybxce\",\"failoverTypes\":[\"PlannedFailover\",\"RepairReplication\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"yiaseqchkrttzraz\",\"failoverTypes\":[\"FinalizeFailback\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"uem\",\"failoverTypes\":[\"FinalizeFailback\",\"CancelFailover\",\"Commit\",\"TestFailoverCleanup\"],\"failoverDirections\":[\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"mnrxxbsojkl\",\"failoverTypes\":[\"CompleteMigration\",\"Failback\",\"TestFailoverCleanup\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]},{\"groupType\":\"Failover\",\"replicationProtectedItems\":[{\"id\":\"sgnzxojpslsvjgpl\",\"virtualMachineId\":\"fiqwoy\"},{\"id\":\"vapcoh\",\"virtualMachineId\":\"ucqpqojxcxzrz\"}],\"startGroupActions\":[{\"actionName\":\"dzbenri\",\"failoverTypes\":[\"SwitchProtection\",\"ChangePit\",\"SwitchProtection\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"ddtjwfljhznam\",\"failoverTypes\":[\"DisableProtection\",\"ChangePit\",\"CancelFailover\",\"FinalizeFailback\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"cqtjzmi\",\"failoverTypes\":[\"CompleteMigration\",\"DisableProtection\",\"Commit\",\"TestFailoverCleanup\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]},{\"groupType\":\"Boot\",\"replicationProtectedItems\":[{\"id\":\"ngrebwg\",\"virtualMachineId\":\"httzlswvajqfutlx\"}],\"startGroupActions\":[{\"actionName\":\"zasunwqrjzfrgq\",\"failoverTypes\":[\"PlannedFailover\",\"ReverseReplicate\",\"CompleteMigration\"],\"failoverDirections\":[\"PrimaryToRecovery\",\"RecoveryToPrimary\",\"PrimaryToRecovery\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"njrohmbpy\",\"failoverTypes\":[\"SwitchProtection\"],\"failoverDirections\":[\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"eblydyv\",\"failoverTypes\":[\"Failback\",\"SwitchProtection\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"PrimaryToRecovery\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"nehvsmt\",\"failoverTypes\":[\"CancelFailover\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"PrimaryToRecovery\",\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"ygvoavyunssxlgh\",\"failoverTypes\":[\"ReverseReplicate\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"vvpa\",\"failoverTypes\":[\"PlannedFailover\",\"ChangePit\",\"DisableProtection\",\"PlannedFailover\"],\"failoverDirections\":[\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"RecoveryToPrimary\",\"PrimaryToRecovery\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"uygdhgaqipirp\",\"failoverTypes\":[\"TestFailoverCleanup\"],\"failoverDirections\":[\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"fulopmjnlexwhcb\",\"failoverTypes\":[\"CancelFailover\",\"ChangePit\",\"CancelFailover\"],\"failoverDirections\":[\"RecoveryToPrimary\"],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]}],\"providerSpecificDetails\":[{\"instanceType\":\"RecoveryPlanProviderSpecificDetails\"},{\"instanceType\":\"RecoveryPlanProviderSpecificDetails\"}]},\"location\":\"uerct\",\"id\":\"toyint\",\"name\":\"pbrlcyrduczkgofx\",\"type\":\"fsrucv\"}")
            .toObject(RecoveryPlanInner.class);
        Assertions.assertEquals("lpaugmrm", model.properties().friendlyName());
        Assertions.assertEquals("lrxw", model.properties().primaryFabricId());
        Assertions.assertEquals("aukhfkvcisiz", model.properties().primaryFabricFriendlyName());
        Assertions.assertEquals("a", model.properties().recoveryFabricId());
        Assertions.assertEquals("sx", model.properties().recoveryFabricFriendlyName());
        Assertions.assertEquals("uivedwcgyeewxeiq", model.properties().failoverDeploymentModel());
        Assertions.assertEquals("mgomg", model.properties().replicationProviders().get(0));
        Assertions.assertEquals("gnxkympqan", model.properties().allowedOperations().get(0));
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-16T02:21:14Z"),
            model.properties().lastPlannedFailoverTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-26T23:15:05Z"),
            model.properties().lastUnplannedFailoverTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-29T00:22:13Z"),
            model.properties().lastTestFailoverTime());
        Assertions.assertEquals("jkhvyomacluzvxnq", model.properties().currentScenario().scenarioName());
        Assertions.assertEquals("rpqpd", model.properties().currentScenario().jobId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-08-05T21:29:24Z"),
            model.properties().currentScenario().startTime());
        Assertions.assertEquals("oi", model.properties().currentScenarioStatus());
        Assertions.assertEquals("css", model.properties().currentScenarioStatusDescription());
        Assertions.assertEquals(RecoveryPlanGroupType.BOOT, model.properties().groups().get(0).groupType());
        Assertions.assertEquals("csypobkdqzrdzsyl",
            model.properties().groups().get(0).replicationProtectedItems().get(0).id());
        Assertions.assertEquals("lgtrczzy",
            model.properties().groups().get(0).replicationProtectedItems().get(0).virtualMachineId());
        Assertions.assertEquals("b", model.properties().groups().get(0).startGroupActions().get(0).actionName());
        Assertions.assertEquals(ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
            model.properties().groups().get(0).startGroupActions().get(0).failoverTypes().get(0));
        Assertions.assertEquals(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
            model.properties().groups().get(0).startGroupActions().get(0).failoverDirections().get(0));
        Assertions.assertEquals("tafsrbxrblmliowx",
            model.properties().groups().get(0).endGroupActions().get(0).actionName());
        Assertions.assertEquals(ReplicationProtectedItemOperation.COMPLETE_MIGRATION,
            model.properties().groups().get(0).endGroupActions().get(0).failoverTypes().get(0));
        Assertions.assertEquals(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
            model.properties().groups().get(0).endGroupActions().get(0).failoverDirections().get(0));
        Assertions.assertEquals("uerct", model.location());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RecoveryPlanInner model = new RecoveryPlanInner()
            .withProperties(new RecoveryPlanProperties().withFriendlyName("lpaugmrm")
                .withPrimaryFabricId("lrxw")
                .withPrimaryFabricFriendlyName("aukhfkvcisiz")
                .withRecoveryFabricId("a")
                .withRecoveryFabricFriendlyName("sx")
                .withFailoverDeploymentModel("uivedwcgyeewxeiq")
                .withReplicationProviders(Arrays.asList("mgomg", "amljdlrgmsplzgau", "cshhv"))
                .withAllowedOperations(Arrays.asList("gnxkympqan", "rjkixtw", "taoypnyghshxc", "lhkgmnsghp"))
                .withLastPlannedFailoverTime(OffsetDateTime.parse("2021-02-16T02:21:14Z"))
                .withLastUnplannedFailoverTime(OffsetDateTime.parse("2021-10-26T23:15:05Z"))
                .withLastTestFailoverTime(OffsetDateTime.parse("2021-06-29T00:22:13Z"))
                .withCurrentScenario(new CurrentScenarioDetails().withScenarioName("jkhvyomacluzvxnq")
                    .withJobId("rpqpd")
                    .withStartTime(OffsetDateTime.parse("2021-08-05T21:29:24Z")))
                .withCurrentScenarioStatus("oi")
                .withCurrentScenarioStatusDescription("css")
                .withGroups(Arrays.asList(
                    new RecoveryPlanGroup().withGroupType(RecoveryPlanGroupType.BOOT)
                        .withReplicationProtectedItems(Arrays.asList(
                            new RecoveryPlanProtectedItem().withId("csypobkdqzrdzsyl").withVirtualMachineId("lgtrczzy"),
                            new RecoveryPlanProtectedItem().withId("xzji").withVirtualMachineId("vuaurk"),
                            new RecoveryPlanProtectedItem().withId("ci").withVirtualMachineId("defxrdc")))
                        .withStartGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("b")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
                                    ReplicationProtectedItemOperation.FAILBACK))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("nnqbnqbp")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FAILBACK,
                                    ReplicationProtectedItemOperation.COMMIT,
                                    ReplicationProtectedItemOperation.PLANNED_FAILOVER,
                                    ReplicationProtectedItemOperation.UNPLANNED_FAILOVER))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("ypxrx")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FAILBACK,
                                    ReplicationProtectedItemOperation.FAILBACK))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails())))
                        .withEndGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("tafsrbxrblmliowx")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.COMPLETE_MIGRATION,
                                    ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
                                    ReplicationProtectedItemOperation.COMMIT,
                                    ReplicationProtectedItemOperation.REPAIR_REPLICATION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("nepzwakls")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.DISABLE_PROTECTION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("wwrxaomzisgl")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FAILBACK,
                                    ReplicationProtectedItemOperation.REVERSE_REPLICATE,
                                    ReplicationProtectedItemOperation.REPAIR_REPLICATION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()))),
                    new RecoveryPlanGroup().withGroupType(RecoveryPlanGroupType.BOOT)
                        .withReplicationProtectedItems(Arrays.asList(
                            new RecoveryPlanProtectedItem().withId("dhqoawj").withVirtualMachineId("yueayfbpcmsp"),
                            new RecoveryPlanProtectedItem().withId("yrrueqth").withVirtualMachineId("gnmbscbbxigdhx"),
                            new RecoveryPlanProtectedItem().withId("d").withVirtualMachineId("pedbwdpyqy")))
                        .withStartGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("ubmdnafcbqwre")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FAILBACK,
                                    ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
                                    ReplicationProtectedItemOperation.CANCEL_FAILOVER))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("geleohdbvq")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
                                    ReplicationProtectedItemOperation.COMPLETE_MIGRATION,
                                    ReplicationProtectedItemOperation.TEST_FAILOVER_CLEANUP,
                                    ReplicationProtectedItemOperation.UNPLANNED_FAILOVER))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("eonrlkwzdqybxce")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.PLANNED_FAILOVER,
                                    ReplicationProtectedItemOperation.REPAIR_REPLICATION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails())))
                        .withEndGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("yiaseqchkrttzraz")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FINALIZE_FAILBACK))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("uem")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
                                    ReplicationProtectedItemOperation.CANCEL_FAILOVER,
                                    ReplicationProtectedItemOperation.COMMIT,
                                    ReplicationProtectedItemOperation.TEST_FAILOVER_CLEANUP))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("mnrxxbsojkl")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.COMPLETE_MIGRATION,
                                    ReplicationProtectedItemOperation.FAILBACK,
                                    ReplicationProtectedItemOperation.TEST_FAILOVER_CLEANUP))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()))),
                    new RecoveryPlanGroup().withGroupType(RecoveryPlanGroupType.FAILOVER)
                        .withReplicationProtectedItems(Arrays.asList(
                            new RecoveryPlanProtectedItem().withId("sgnzxojpslsvjgpl").withVirtualMachineId("fiqwoy"),
                            new RecoveryPlanProtectedItem().withId("vapcoh").withVirtualMachineId("ucqpqojxcxzrz")))
                        .withStartGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("dzbenri")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.SWITCH_PROTECTION,
                                    ReplicationProtectedItemOperation.CHANGE_PIT,
                                    ReplicationProtectedItemOperation.SWITCH_PROTECTION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("ddtjwfljhznam")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.DISABLE_PROTECTION,
                                    ReplicationProtectedItemOperation.CHANGE_PIT,
                                    ReplicationProtectedItemOperation.CANCEL_FAILOVER,
                                    ReplicationProtectedItemOperation.FINALIZE_FAILBACK))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails())))
                        .withEndGroupActions(Arrays
                            .asList(new RecoveryPlanAction().withActionName("cqtjzmi")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.COMPLETE_MIGRATION,
                                    ReplicationProtectedItemOperation.DISABLE_PROTECTION,
                                    ReplicationProtectedItemOperation.COMMIT,
                                    ReplicationProtectedItemOperation.TEST_FAILOVER_CLEANUP))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()))),
                    new RecoveryPlanGroup().withGroupType(RecoveryPlanGroupType.BOOT)
                        .withReplicationProtectedItems(Arrays.asList(
                            new RecoveryPlanProtectedItem().withId("ngrebwg").withVirtualMachineId("httzlswvajqfutlx")))
                        .withStartGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("zasunwqrjzfrgq")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.PLANNED_FAILOVER,
                                    ReplicationProtectedItemOperation.REVERSE_REPLICATE,
                                    ReplicationProtectedItemOperation.COMPLETE_MIGRATION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("njrohmbpy")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.SWITCH_PROTECTION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("eblydyv")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.FAILBACK,
                                    ReplicationProtectedItemOperation.SWITCH_PROTECTION))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("nehvsmt")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.CANCEL_FAILOVER))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails())))
                        .withEndGroupActions(Arrays.asList(
                            new RecoveryPlanAction().withActionName("ygvoavyunssxlgh")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.REVERSE_REPLICATE))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("vvpa")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.PLANNED_FAILOVER,
                                    ReplicationProtectedItemOperation.CHANGE_PIT,
                                    ReplicationProtectedItemOperation.DISABLE_PROTECTION,
                                    ReplicationProtectedItemOperation.PLANNED_FAILOVER))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
                                    PossibleOperationsDirections.PRIMARY_TO_RECOVERY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("uygdhgaqipirp")
                                .withFailoverTypes(
                                    Arrays.asList(ReplicationProtectedItemOperation.TEST_FAILOVER_CLEANUP))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails()),
                            new RecoveryPlanAction().withActionName("fulopmjnlexwhcb")
                                .withFailoverTypes(Arrays.asList(ReplicationProtectedItemOperation.CANCEL_FAILOVER,
                                    ReplicationProtectedItemOperation.CHANGE_PIT,
                                    ReplicationProtectedItemOperation.CANCEL_FAILOVER))
                                .withFailoverDirections(Arrays.asList(PossibleOperationsDirections.RECOVERY_TO_PRIMARY))
                                .withCustomDetails(new RecoveryPlanActionDetails())))))
                .withProviderSpecificDetails(Arrays.asList(new RecoveryPlanProviderSpecificDetails(),
                    new RecoveryPlanProviderSpecificDetails())))
            .withLocation("uerct");
        model = BinaryData.fromObject(model).toObject(RecoveryPlanInner.class);
        Assertions.assertEquals("lpaugmrm", model.properties().friendlyName());
        Assertions.assertEquals("lrxw", model.properties().primaryFabricId());
        Assertions.assertEquals("aukhfkvcisiz", model.properties().primaryFabricFriendlyName());
        Assertions.assertEquals("a", model.properties().recoveryFabricId());
        Assertions.assertEquals("sx", model.properties().recoveryFabricFriendlyName());
        Assertions.assertEquals("uivedwcgyeewxeiq", model.properties().failoverDeploymentModel());
        Assertions.assertEquals("mgomg", model.properties().replicationProviders().get(0));
        Assertions.assertEquals("gnxkympqan", model.properties().allowedOperations().get(0));
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-16T02:21:14Z"),
            model.properties().lastPlannedFailoverTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-26T23:15:05Z"),
            model.properties().lastUnplannedFailoverTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-29T00:22:13Z"),
            model.properties().lastTestFailoverTime());
        Assertions.assertEquals("jkhvyomacluzvxnq", model.properties().currentScenario().scenarioName());
        Assertions.assertEquals("rpqpd", model.properties().currentScenario().jobId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-08-05T21:29:24Z"),
            model.properties().currentScenario().startTime());
        Assertions.assertEquals("oi", model.properties().currentScenarioStatus());
        Assertions.assertEquals("css", model.properties().currentScenarioStatusDescription());
        Assertions.assertEquals(RecoveryPlanGroupType.BOOT, model.properties().groups().get(0).groupType());
        Assertions.assertEquals("csypobkdqzrdzsyl",
            model.properties().groups().get(0).replicationProtectedItems().get(0).id());
        Assertions.assertEquals("lgtrczzy",
            model.properties().groups().get(0).replicationProtectedItems().get(0).virtualMachineId());
        Assertions.assertEquals("b", model.properties().groups().get(0).startGroupActions().get(0).actionName());
        Assertions.assertEquals(ReplicationProtectedItemOperation.FINALIZE_FAILBACK,
            model.properties().groups().get(0).startGroupActions().get(0).failoverTypes().get(0));
        Assertions.assertEquals(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
            model.properties().groups().get(0).startGroupActions().get(0).failoverDirections().get(0));
        Assertions.assertEquals("tafsrbxrblmliowx",
            model.properties().groups().get(0).endGroupActions().get(0).actionName());
        Assertions.assertEquals(ReplicationProtectedItemOperation.COMPLETE_MIGRATION,
            model.properties().groups().get(0).endGroupActions().get(0).failoverTypes().get(0));
        Assertions.assertEquals(PossibleOperationsDirections.RECOVERY_TO_PRIMARY,
            model.properties().groups().get(0).endGroupActions().get(0).failoverDirections().get(0));
        Assertions.assertEquals("uerct", model.location());
    }
}
