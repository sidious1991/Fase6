export interface Metric {
  metricId: string;
	description: string;
	count: string;
	metricUnits: string[];
	scaleType: string;
	limH: string;
  limL: string;
	creationDate: string;
	version: number;
}