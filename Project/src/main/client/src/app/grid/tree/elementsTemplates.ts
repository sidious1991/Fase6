export const Goal = 'Goal';
export let GoalTemplate: Object = {
  goalId: "",
  version: 0,
  creationDate: "",
  lastModified: "",
  timeFrame: "",
  object: "",
  magnitude: 0,
  focus: "",
  costraint: "",
  organizationalScope: "",
  description: "",
  measurementRef: [],
  strategyRef: []
}

export const Strategy = 'Strategy';
export let StrategyTemplate: Object = {
  strategyId: "",
	context: [],
	assumptions: [],
	description: "",
	creationDate: "",
	lastModified: "",
	timeFrame: "",
	version: 0,
  goalRef: []
}

export const MeasurementGoal = 'MeasurementGoal';
export let MeasurementGoalTemplate: Object = {
  measurementGoalId: "",
  object: "",
  purpose: "",
  qualityFocus: "",
  viewpoint: "",
  context: "",
  creationDate: "",
  lastModified: "",
  interpretationModel: "", 
  version: 0,
  questionsRef: [],
  metricsRef: []
}

export const Question = 'Question';
export let QuestionTemplate: Object = {
  questionId: "",
	description: "",
	creationDate: "",
	lastModified: "",
	timeFrame: "",
	version: 0,
	focus: ""
}

export const Metric = 'Metric';
export let MetricTemplate: Object = {
  metricId: "",
	description: "",
	count: "",
	metricUnits: [],
	scaleType: "",
	limH: "",
  limL: "",
	creationDate: "",
	version: 0
}
