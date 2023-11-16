import { ContractInfo } from "./ContractInfo";
import { SalaryInfo } from "./SalaryInfo";

export interface Employee {
employeeId : String,
countryCode : String,
firstName : String,
middleName : String,
lastName : String,
email : String,
contract : ContractInfo,
salary : SalaryInfo
}