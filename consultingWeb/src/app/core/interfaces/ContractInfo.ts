import { CostCenter } from "./CostCenter";
import { JobProfile } from "./JobProfile";

export interface ContractInfo{
    jobProfile : JobProfile,
    hireDate : Date,
    costCenter : CostCenter,
    type : String,
    timeType : String
}