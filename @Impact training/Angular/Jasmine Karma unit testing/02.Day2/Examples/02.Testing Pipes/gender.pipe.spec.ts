import { GenderPipe } from './gender.pipe';

describe('GenderPipe', () => {

  let pipe:GenderPipe;

  beforeEach(() => {
    pipe = new GenderPipe();
  });

  // 1. Test Pipe class instance
  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  // 2. Test Pipe class method
  it('should return "Male" when input is  "m" ', () => {
    const result:string  = pipe.transform("m");
    expect(result).toBe("Male");
  });

  // 3. Test Pipe class method
  it('should return "Male" when input is  "M" ', () => {
    const result:string  = pipe.transform("M");
    expect(result).toBe("Male");
  });


  // 4. Test Pipe class method
  it('should return "Female" when input is  "f" ', () => {
    const result:string  = pipe.transform("f");
    expect(result).toBe("Female");
  });

  // 5. Test Pipe class method
  it('should return "Female" when input is  "F" ', () => {
    const result:string  = pipe.transform("F");
    expect(result).toBe("Female");
  });


  // 6. Test pipe method with wrong values
  it('should return empty when input is invalid gender', () => {
    const result:string  = pipe.transform("hello");
    expect(result).toBe("");
  });





});
