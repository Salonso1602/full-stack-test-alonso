import { JobProfile } from "./JobProfile";
import { CostCenter } from "./CostCenter";

export interface Employee {
employeeId : String,
countryCode : String,
firstName : String,
middleName : String,
lastName : String,
email : String,
type : String,
timeType : String,
jobProfile : JobProfile,
hireDate : Date,
costCenter : CostCenter
}