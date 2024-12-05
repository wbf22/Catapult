curl --location -v --trace-ascii curllog.txt 'https://attractions-api.accessdevelopment-stage.com/v1/attractions/admin/digital-codes/prd_0GV2BJMV03MBY' \
--form 'expiration="2025-01-02T14:00:00+00"' \
--form 'threshold="10"' \
--form 'file=@"test.csv"'


curl --location 'https://attractions-api.accessdevelopment-stage.com/v1/attractions/admin/digital-codes/prd_0GV2BJMV03MBY' \
--form 'expiration="2025-01-02T14:00:00+00"' \
--form 'threshold="10"' \
--form 'file=@"test.csv"'

curl --location 'https://attractions-api.accessdevelopment-stage.com/v1/attractions/admin/digital-codes/prd_0GV2BJMV03MBY' \
--form 'expiration="2025-01-02T14:00:00+00"' \
--form 'threshold="10"' \
--form 'file=@"test.csv"'