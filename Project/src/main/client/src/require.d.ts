interface NodeRequire {
  // ensure: (paths: string[], callback: (require: <T>(path: string) => T) => void) => void;
  ensure: (paths: string[], callback: (require: <T>(path: string) => T) => void, name?:string ) => void;
}

/*
declare var require: {
    <T>(path: string): T;
    (paths: string[], callback: (...modules: any[]) => void): void;
    ensure: (paths: string[], callback: (require: <T>(path: string) => T) => void) => void;
};
*/
