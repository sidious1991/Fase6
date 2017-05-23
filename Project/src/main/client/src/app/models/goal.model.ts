import { MeasurementGoal } from './measurementGoal.model'
import { Strategy } from './strategy.model'

export interface Goal {
  goalId: string;
  version: number;
  creationDate: string;
  lastModified: string;
  timeFrame: string;
  object: string;
  magnitude: number;
  focus: string;
  costraint: string;
  organizationalScope: string;
  description: string;
  measurementRef: MeasurementGoal[];
  strategyRef: Strategy[];
}
