var a:array[1..66000] of boolean;
n,g,k,m,i,test,nn:integer;
fl:boolean;
function pow(x,n,p:integer):integer;
var a,b:Int64;
begin
  a:=1; b:=x;
  while n>0 do
  begin
    if n and 1 = 1 then a:=(a*b) mod p;
    b:=(b*b) mod p;
    n:=n shr 1;
  end;
  Result:=a;
end;

begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);    }
  FillChar(a,SizeOf(a),true);
  m:=Trunc(Sqrt(66000))+1;
  for n:=2 to m do
    if a[n] then
    begin
      k:=n*n;
      while k<=66000 do
      begin
        a[k]:=false;
        inc(k,n);
      end;
    end;
{  for n:=3 to 66000 do
  begin
    if a[n] then
    begin
      Write(n,' ');
      for g:=n-1 downto 2 do
      begin
        fl:=true;
        m:=n-1; k:=2; nn:=m;
        while k<=m do
        begin
          if a[k] and (nn mod k = 0) then
          begin
            if pow(g,nn div k,n)=1 then
            begin
              fl:=false;
              break;
            end;
         //  while (m mod k = 0) do m:=m div k;
           m:=m div k;
          end;
          inc(k);
        end;
        if fl then
        begin
          Writeln(g);
          break;
        end;
      end;
    end;
  end;      }
  Read(test);
  for i:=1 to test do
  begin
    Read(n);
    begin
    //  Write(n,' ');
      for g:=n-1 downto 2 do
      begin
        fl:=true;
        m:=n-1; k:=2; nn:=m;
        while k<=m do
        begin
          if a[k] and (nn mod k = 0) then
          begin
            if pow(g,nn div k,n)=1 then
            begin
              fl:=false;
              break;
            end;
         //  while (m mod k = 0) do m:=m div k;
           m:=m div k;
          end;
          inc(k);
        end;
        if fl then
        begin
          Writeln(g);
          break;
        end;
      end;
    end;
  end;
 // Close(input);Close(output);
end.
