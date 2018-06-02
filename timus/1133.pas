{$APPTYPE CONSOLE}
var i,j,k,n,t:integer;
fi,fj,fn,f1,f0:extended;
a:array[0..2000] of extended;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);   }
  Read(i,Fi,j,Fj,n);
  if i<j then k:=i else k:=j;
  i:=i-k; j:=j-k; n:=n-k;
  if i=0 then k:=j else k:=i;
  a[0]:=0; a[1]:=1;
  for t:=2 to k do a[t]:=a[t-1]+a[t-2];
  if i=0 then
  begin
    f0:=fi;
    f1:=(fj-a[j-1]*f0) / a[j];
  end else
  begin
    f0:=fj;
    f1:=(fi-a[i-1]*f0) / a[i];
  end;
  k:=n;
  if k>=0 then
  begin
    a[0]:=f0;
    a[1]:=f1;
    for t:=2 to k do a[t]:=a[t-1]+a[t-2];
    fn:=a[k];
  end else
  begin
    a[1000]:=f1;
    a[999]:=f0;
    t:=999;
    k:=-k;
    while k>0 do
    begin
      dec(k);
      dec(t);
      a[t]:=a[t+2]-a[t+1];
    end;
    fn:=a[t];
  end;
  Writeln(fn:0:0);

 // Close(input); Close(output);
end.