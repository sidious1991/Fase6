import { Goal } from './goal.model';

export interface Strategy {
  strategyId: string;
	context: string[];
	assumptions: string[];
	description: string;
	creationDate: string;
	lastModified: string;
	timeFrame: string;
	version: number;
  goalRef: Goal[];
}