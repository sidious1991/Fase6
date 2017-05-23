export interface RetrospectiveReport {
  retrospectiveReportId: string;
	conclusion: string;
	lastModified: string;
	ids: number[];
	priorityList: string[];
	descriptionList: string[];
}
